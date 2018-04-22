# BiliBiliOneKey
BiliBili一键开播，兼容Sync的配置文件

程序里写死了获取当前路径是exe结尾，所以如果是自行编译的jar，请用[IKVM.NET](http://weblog.ikvm.net/2015/08/26/IKVMNET81ReleaseCandidate0.aspx)打包编译。

（当然你也可以改为jar然后建立批处理运行）

编译为exe文件后，程序同一目录下需要的dll有：
+ IKVM.OpenJDK.Charsets.dll
+ IKVM.OpenJDK.Core.dll
+ IKVM.OpenJDK.Jdbc.dll
+ IKVM.OpenJDK.Security.dll
+ IKVM.OpenJDK.Text.dll
+ IKVM.OpenJDK.Util.dll
+ IKVM.Runtime.dll
+ IKVM.Runtime.JNI.dll
+ ikvm-native-win32-x64.dll
+ ikvm-native-win32-x86.dll
