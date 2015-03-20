using System;
using System.Collections.Generic;
using System.Net;
using System.Text;

namespace Downloader
{
    /**Web客户端**/
    class MyWebClient : WebClient
    {
        private int time_out = 15 * 1000;
        public MyWebClient(int time_out):base()
        {
            this.time_out = time_out;
        }
        protected override WebRequest GetWebRequest(Uri address)
        {
            HttpWebRequest request = (HttpWebRequest)base.GetWebRequest(address);
            request.Timeout = time_out;//设置超时为1分钟
            request.ReadWriteTimeout = time_out;
            return request;
        }
    }
}
