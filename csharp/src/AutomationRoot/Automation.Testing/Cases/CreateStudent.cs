using Automation.Core.Components;
using Automation.Core.Testing;
using Automation.Framework.Ui.Pages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Testing.Cases
{
    public class CreateStudent : TestCase
    {
        public override bool AutomationTest(IDictionary<string, object> testParams)
        {
            // students to find
            var keyword = $"{testParams["keyword"]}";

            // perform test case
            return new FluentUi(Driver)
                .ChangeContext<StudentsUi>($"{testParams["application"]}")
                .Create()
                .FirstName("csharp")
                .LastName("student")
                .EnrollementDate(DateTime.Now)
                .Create()
                .FindByName("csharp")
                .Students()
                .Any();
        }
    }
}
