using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Testing;
using Automation.Extensions.Components;
using Automation.Extensions.Contracts;
using Automation.Framework.Ui.Pages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Testing.Cases
{
    public class SearchStudents : TestCase
    {
        public override bool AutomationTest(IDictionary<string, object> testParams)
        {
            // creating driver for this case
            var driver = new WebDriverFactory(new DriverParams { Binaries = ".", Driver = "CHROME" }).Get();

            // perform test case
            return new FluentUi(driver)
                .ChangeContext<StudentsUi>("https://gravitymvctestapplication.azurewebsites.net/Student")
                .FindByName("Alexander")
                .Students()
                .All(i => i.FirstName().Equals("Alexander") || i.LastName().Equals("Alexander"));
        }
    }
}