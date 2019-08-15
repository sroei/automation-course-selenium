using Automation.Core.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Components
{
    public abstract class FluentBase : IFluent
    {
        protected FluentBase(ILogger logger)
        {
            Logger = logger;
        }

        public ILogger Logger { get; }

        public T ChangeContext<T>()
        {
            var instance = Create<T>(null, null);
            Logger.Debug($"instance of [{GetType()?.FullName}] created");
            return instance;
        }

        public T ChangeContext<T>(ILogger logger)
        {
            return Create<T>(null, logger);
        }

        public abstract T ChangeContext<T>(string application, ILogger logger);

        public abstract T ChangeContext<T>(string application);

        public abstract T ChangeContext<T>(string type, string application);

        internal abstract T Create<T>(Type type, ILogger logger);
    }
}