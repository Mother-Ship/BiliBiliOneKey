# BiliBiliOneKey
BiliBili一键开播，兼容[Sync](https://github.com/OsuSync/Sync)的配置文件格式，带有自动修改OBS Studio配置的功能 **（只支持新版OBS）**。

更换了获取当前目录的方式（直接获取环境变量，具体见代码）。

我的release将程序使用[IKVM.NET](http://weblog.ikvm.net/2015/08/26/IKVMNET81ReleaseCandidate0.aspx)编译为EXE文件，请将压缩包内的DLL文件（实质是简易JVM）一起解压到Sync目录下！