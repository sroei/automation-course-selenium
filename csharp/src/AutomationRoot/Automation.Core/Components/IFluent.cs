using Automation.Core.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Components
{
    public interface IFluent
    {
        T ChangeContext<T>();
        T ChangeContext<T>(ILogger logger);
        T ChangeContext<T>(string application, ILogger logger);
        T ChangeContext<T>(string application);
    }
}
