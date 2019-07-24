using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Logging
{
    public class TraceLogger : ILogger
    {
        public void Debug(string message)
        {
            Trace.TraceInformation(message);
        }

        public void Debug(string format, params object[] args)
        {
            Trace.TraceInformation(string.Format(format, args));
        }

        public void Debug(Exception exception, string message)
        {
            Trace.TraceError(message + " " + $"{exception}");
        }
    }
}
