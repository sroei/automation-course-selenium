using Automation.Core.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Testing
{
    public abstract class TestCase
    {
        // fields
        private IDictionary<string, object> testParams;
        private int attempts;
        private ILogger logger;

        // components        
        public abstract bool AutomationTest(IDictionary<string, object> testParams);

        public TestCase Execute()
        {
            return this;
        }

        // configuration
        public TestCase WithTestParams(IDictionary<string, object> testParams)
        {
            this.testParams = testParams;
            return this;
        }

        public TestCase WithNumberOfAttempts(int numberOfAttempts)
        {
            attempts = numberOfAttempts;
            return this;
        }

        public TestCase WithLogger(ILogger logger)
        {
            this.logger = logger;
            return this;
        }
    }
}
