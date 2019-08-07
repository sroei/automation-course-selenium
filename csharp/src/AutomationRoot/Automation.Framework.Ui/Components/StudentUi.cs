using Automation.Api.Components;
using Automation.Core.Components;
using Automation.Core.Logging;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Framework.Ui.Components
{
    public class StudentUi : FluentUi, IStudent
    {
        private readonly IWebElement dataRow;

        public StudentUi(IWebDriver driver, IWebElement dataRow)
            : this(driver, new TraceLogger())
        {
            this.dataRow = dataRow;
        }

        private StudentUi(IWebDriver driver, ILogger logger)
            : base(driver, logger) { }

        // actions
        public object Delete()
        {
            throw new NotImplementedException();
        }

        public object Details()
        {
            throw new NotImplementedException();
        }

        public object Edit()
        {
            throw new NotImplementedException();
        }

        // data
        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public string FirstName()
        {
            throw new NotImplementedException();
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }
    }
}