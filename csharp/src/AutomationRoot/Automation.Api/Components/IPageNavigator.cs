using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Components
{
    public interface IPageNavigator<out T>
    {
        T Next();
        T Previous();
        int Pages();
        int Page();
    }
}
