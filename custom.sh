## Your customization code

startwd="$(pwd)"
if [[  "$startwd" == "/R/#CacheBackup#"* ]]; then 
    mount -fo binary,noacl,posix=0,user R:/#CacheBackup# /git/vms
    cd ${startwd/#\/R\/#CacheBackup#/\/git\/vms}
    export remoteurl=
fi


