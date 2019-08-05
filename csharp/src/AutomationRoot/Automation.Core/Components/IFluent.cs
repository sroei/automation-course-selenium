using Automation.Core.Logging;

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
