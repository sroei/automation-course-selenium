using Automation.Api.Components;
using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Automation.Extensions.Components;
using OpenQA.Selenium;
using System;

namespace Automation.Framework.Ui.Pages
{
    public class StudentDetailsUi : FluentUi, IStudentDetails
    {
        public StudentDetailsUi(IWebDriver driver)
            : base(driver) { }

        public StudentDetailsUi(IWebDriver driver, ILogger logger)
            : base(driver, logger) { }

        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public IEnrollment[] Enrollments()
        {
            throw new NotImplementedException();
        }

        public string FirstName()
        {
            return Driver.GetElement(By.XPath("//dd[2]")).Text.Trim();
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }
    }
}