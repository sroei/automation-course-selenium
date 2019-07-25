using Automation.Core.Logging;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Components
{
    public class FluentUi : IFluent
    {
        private readonly IWebDriver driver;
        private readonly ILogger logger;

        public FluentUi(IWebDriver driver)
            : this(driver, new TraceLogger()) { }

        public FluentUi(IWebDriver driver, ILogger logger)
        {
            this.driver = driver;
            this.logger = logger;
        }

        public T ChangeContext<T>()
        {
            throw new NotImplementedException();
        }

        public T ChangeContext<T>(string application)
        {
            throw new NotImplementedException();
        }
    }
}