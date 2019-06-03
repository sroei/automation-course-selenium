using Automation.Extensions.Contracts;
using Newtonsoft.Json;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Remote;
using System;
using System.Collections.Generic;
using System.Text;

namespace Automation.Extensions.Components
{
    public class WebDriverFactory
    {
        private readonly DriverParams driverParams;

        public WebDriverFactory(string driverParamsJson)
            : this(LoadParams(driverParamsJson)) { }

        public WebDriverFactory(DriverParams driverParams)
        {
            this.driverParams = driverParams;
            if (string.IsNullOrEmpty(driverParams.Binaries) || driverParams.Binaries == ".")
            {
                driverParams.Binaries = Environment.CurrentDirectory;
            }
        }

        // local web-drivers
        private IWebDriver GetChrome() => new ChromeDriver(driverParams.Binaries);
        private IWebDriver GetFirefox() => new FirefoxDriver(driverParams.Binaries);
        private IWebDriver GetInternetExplorer() => new InternetExplorerDriver(driverParams.Binaries);
        private IWebDriver GetEdge() => new EdgeDriver(driverParams.Binaries);

        // remote web-drivers
        private IWebDriver GetRemoteChrome()
            => new RemoteWebDriver(new Uri(driverParams.Binaries), new ChromeOptions());

        private IWebDriver GetRemoteFirefox()
            => new RemoteWebDriver(new Uri(driverParams.Binaries), new FirefoxOptions());

        private IWebDriver GetRemoteInternetExplorer()
            => new RemoteWebDriver(new Uri(driverParams.Binaries), new InternetExplorerOptions());

        private IWebDriver GetRemoteEdge()
            => new RemoteWebDriver(new Uri(driverParams.Binaries), new EdgeOptions());

        // load json into driver-params object
        private static DriverParams LoadParams(string driverParamsJson)
        {
            if (string.IsNullOrEmpty(driverParamsJson))
            {
                return new DriverParams { Source = "Local", Driver = "Chrome", Binaries = "." };
            }
            return JsonConvert.DeserializeObject<DriverParams>(driverParamsJson);
        }
    }
}