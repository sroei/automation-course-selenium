using Automation.Core.Logging;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Components
{
    public abstract class FluentUi : IFluent
    {
        private readonly IWebDriver driver;
        private readonly ILogger logger;

        protected FluentUi(IWebDriver driver)
            : this(driver, new TraceLogger()) { }

        protected FluentUi(IWebDriver driver, ILogger logger)
        {
            this.driver = driver;
            this.logger = logger;
        }

        public T ChangeContext<T>()
        {
            var instance = Create<T>(null);
            logger.Debug($"instance of [{GetType()?.FullName}] created");
            return instance;
        }

        public T ChangeContext<T>(ILogger logger)
        {
            return Create<T>(logger);
        }

        public T ChangeContext<T>(string application, ILogger logger)
        {
            driver.Navigate().GoToUrl(application);
            driver.Manage().Window.Maximize();
            return Create<T>(logger);
        }

        public T ChangeContext<T>(string application)
        {
            driver.Navigate().GoToUrl(application);
            driver.Manage().Window.Maximize();
            return Create<T>(null);
        }

        private T Create<T>(ILogger logger)
        {
            return logger == null
                ? (T)Activator.CreateInstance(typeof(T), new object[] { driver })
                : (T)Activator.CreateInstance(typeof(T), new object[] { driver, logger });
        }
    }
}