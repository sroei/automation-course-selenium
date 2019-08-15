using Automation.Core.Components;
using Automation.Core.Logging;
using Automation.Extensions.Components;
using Automation.Extensions.Contracts;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;

namespace Automation.Core.Testing
{
    public abstract class TestCase
    {
        // fields
        private IDictionary<string, object> testParams;
        private int attempts;
        private ILogger logger;

        protected TestCase()
        {
            testParams = new Dictionary<string, object>();
            attempts = 1;
            logger = new TraceLogger();
        }

        // components        
        public abstract bool AutomationTest(IDictionary<string, object> testParams);

        public TestCase Execute()
        {
            for (int i = 0; i < attempts; i++)
            {
                Setup();
                try
                {
                    Actual = AutomationTest(testParams);
                    if (Actual)
                    {
                        break;
                    }
                    logger.Debug($"[{GetType()?.FullName}] failed on attempt [{i + 1}]");
                }
                catch (AssertInconclusiveException ex)
                {
                    logger.Debug(ex, ex.Message);
                    break;
                }
                catch (NotImplementedException ex)
                {
                    logger.Debug(ex, ex.Message);
                    break;
                }
                catch (Exception ex)
                {
                    logger.Debug(ex, ex.Message);
                }
                finally
                {
                    Driver?.Close();
                    Driver?.Dispose();
                }
            }
            return this;
        }

        // properties
        public bool Actual { get; private set; }

        public IWebDriver Driver { get; private set; }

        public HttpClient HttpClient { get; private set; }

        // configuration
        public TestCase WithTestParams(IDictionary<string, object> testParams)
        {
            this.testParams = testParams;
            return this;
        }

        public TestCase WithNumberOfAttempts(int numberOfAttempts)
        {
            attempts = numberOfAttempts;
            return this;
        }

        public TestCase WithLogger(ILogger logger)
        {
            this.logger = logger;
            return this;
        }

        // factory
        public IFluent CreateFluentApi(string type)
        {
            // extract type
            var t = Utilities.GetTypeByName(type);

            // extract constructors
            var ctr = t.GetConstructors();

            // setup conditions
            var isFluent = typeof(FluentBase).IsAssignableFrom(t);
            var isRest = isFluent && ctr.Any(i => i.GetParameters().Any(p => p.ParameterType == typeof(HttpClient)));
            var isFront = isFluent && ctr.Any(i => i.GetParameters().Any(p => p.ParameterType == typeof(IWebDriver)));

            // factoring
            if (isRest)
            {
                return (IFluent)Activator.CreateInstance(t, new object[] { HttpClient, logger });
            }
            else if (isFront)
            {
                return (IFluent)Activator.CreateInstance(t, new object[] { Driver, logger });
            }
            throw new NotFoundException($"implementation of {type} was not found");
        }

        // setup
        private void Setup()
        {
            // constants
            const string DRIVER = "driver";

            // default
            var driverParams = new DriverParams { Binaries = ".", Driver = "CHROME" };

            // change driver if exists
            if (testParams?.ContainsKey(DRIVER) == true)
            {
                driverParams.Driver = $"{testParams[DRIVER]}";
            }
            else
            {
                testParams[DRIVER] = string.Empty;
            }
            if ($"{testParams[DRIVER]}".Equals("HTTP", StringComparison.OrdinalIgnoreCase))
            {
                HttpClient = new HttpClient();
                return;
            }

            // create driver
            Driver = new WebDriverFactory(driverParams).Get();
        }
    }
}