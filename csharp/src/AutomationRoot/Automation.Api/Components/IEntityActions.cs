using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Components
{
    public interface IEntityActions
    {
        object Edit();
        object Details();
        object Delete();
    }
}
