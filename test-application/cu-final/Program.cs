using ContosoUniversity.Data;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Diagnostics;

namespace ContosoUniversity
{
    public static class Program
    {
        public static void Main(string[] args) => CreateWebHostBuilder(args).Build().Setup().Run();

        private static IWebHost Setup(this IWebHost host)
        {
            using (var scope = host.Services.CreateScope())
            {
                var services = scope.ServiceProvider;
                var context = services.GetRequiredService<SchoolContext>();
                try
                {
                    DbInitializer.Clean(context.Database.GetDbConnection().ConnectionString);
                }
                catch (Exception ex)
                {
                    Trace.TraceError($"{ex}");
                }
                finally
                {
                    context.Database.Migrate();
                    DbInitializer.Initialize(context);
                }
            }
            return host;
        }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args) => WebHost
            .CreateDefaultBuilder(args)
            .UseStartup<Startup>();
    }
}