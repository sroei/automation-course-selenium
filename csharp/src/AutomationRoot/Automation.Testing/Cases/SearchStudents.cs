using Automation.Core.Components;
using Automation.Core.Testing;
using Automation.Extensions.Components;
using Automation.Extensions.Contracts;
using Automation.Framework.Ui.Pages;
using System.Collections.Generic;
using System.Linq;

namespace Automation.Testing.Cases
{
    public class SearchStudents : TestCase
    {
        public override bool AutomationTest(IDictionary<string, object> testParams)
        {
            // creating driver for this case
            var driver = new WebDriverFactory(new DriverParams { Binaries = ".", Driver = $"{testParams["driver"]}" }).Get();

            // students to find
            var keyword = $"{testParams["keyword"]}";

            // perform test case
            return new FluentUi(driver)
                .ChangeContext<StudentsUi>($"{testParams["application"]}")
                .FindByName(keyword)
                .Students()
                .All(i => i.FirstName().Equals(keyword) || i.LastName().Equals(keyword));
        }
    }
}