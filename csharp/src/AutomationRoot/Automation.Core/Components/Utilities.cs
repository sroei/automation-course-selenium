using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Core.Components
{
    internal static class Utilities
    {
        public static Type GetTypeByName(string type)
        {
            const string ASSEMBLY = "Automation.Testing, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null";

            var assemblies = new List<Assembly>();
            foreach (var assembly in Assembly.Load(ASSEMBLY).GetReferencedAssemblies())
            {
                assemblies.Add(Assembly.Load(assembly));
            }
            return assemblies
                .SelectMany(i => i.GetTypes())
                .FirstOrDefault(i => i.FullName.Equals(type, StringComparison.OrdinalIgnoreCase));
        }
    }
}
