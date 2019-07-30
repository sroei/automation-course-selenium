using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Components
{
    public interface IBack<out T>
    {
        T BackToList();
    }
}
