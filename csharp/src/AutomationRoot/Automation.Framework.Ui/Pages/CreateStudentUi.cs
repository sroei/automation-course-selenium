using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Automation.Extensions.Components;
using OpenQA.Selenium;
using System;

namespace Automation.Framework.Ui.Pages
{
    public class CreateStudentUi : FluentUi, ICreateStudent
    {
        public CreateStudentUi(IWebDriver driver)
            : base(driver) { }

        public CreateStudentUi(IWebDriver driver, ILogger logger)
            : base(driver, logger) { }

        public IStudents BackToList()
        {
            throw new NotImplementedException();
        }

        public IStudents Create()
        {
            Driver.GetEnabledElement(By.XPath("//input[@type='submit']")).Click();
            return new StudentsUi(Driver);
        }

        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent EnrollementDate(DateTime enrollementDate)
        {
            var script = $"document.getElementById('EnrollmentDate').setAttribute('value','{enrollementDate.ToString("yyyy-MM-dd")}');";
            ((IJavaScriptExecutor)Driver).ExecuteScript(script);
            return this;
        }

        public string FirstName()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent FirstName(string firstName)
        {
            Driver.GetEnabledElement(By.XPath("//input[@id='FirstMidName']")).SendKeys(firstName);
            return this;
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent LastName(string lastName)
        {
            Driver.GetEnabledElement(By.XPath("//input[@id='LastName']")).SendKeys(lastName);
            return this;
        }
    }
}