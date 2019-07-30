using Automation.Api.Pages;
using Automation.Core.Testing;
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
            IStudents students = null;
            return students.FindByName("Alexander").Students().Any();
        }
    }
}