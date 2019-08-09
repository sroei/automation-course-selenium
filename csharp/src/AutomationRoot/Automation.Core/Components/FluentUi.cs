using Automation.Core.Logging;
using Automation.Extensions.Components;
using Automation.Extensions.Contracts;
using OpenQA.Selenium;
using System;

namespace Automation.Core.Components
{
    public class FluentUi : FluentBase
    {
        public FluentUi(string driverParams)
            : this(new WebDriverFactory(driverParams).Get()) { }

        public FluentUi(DriverParams driverParams)
            : this(new WebDriverFactory(driverParams).Get()) { }

        public FluentUi(WebDriverFactory webDriverFactory)
            : this(webDriverFactory.Get()) { }

        public FluentUi(IWebDriver driver)
            : this(driver, new TraceLogger()) { }

        public FluentUi(IWebDriver driver, ILogger logger) : base(logger)
        {
            Driver = driver;
        }

        public IWebDriver Driver { get; }

        public override T ChangeContext<T>(string application, ILogger logger)
        {
            Driver.Navigate().GoToUrl(application);
            Driver.Manage().Window.Maximize();
            return Create<T>(logger);
        }

        public override T ChangeContext<T>(string application)
        {
            Driver.Navigate().GoToUrl(application);
            Driver.Manage().Window.Maximize();
            return Create<T>(null);
        }

        internal override T Create<T>(ILogger logger)
        {
            return logger == null
                ? (T)Activator.CreateInstance(typeof(T), new object[] { Driver })
                : (T)Activator.CreateInstance(typeof(T), new object[] { Driver, logger });
        }
    }
}