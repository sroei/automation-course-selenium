using Automation.Testing.Cases;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Testing.Containers
{
    [TestClass]
    public class StudentTests
    {
        [TestMethod]
        public void SearchStudentUiTest()
        {
            var actual = new SearchStudents().Execute().Actual;
            Assert.IsTrue(actual);
        }
    }
}
