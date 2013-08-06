#!/bin/bash
#
# chkconfig: 3 80 05
# description: Startup script for Glassfish
GLASSFISH_HOME=/opt/glassfish/bin;
GLASSFISH_OWNER=gfish;
NODE=n2
INSTANCE=i2

export GLASSFISH_HOME GLASSFISH_OWNER NODE INSTANCE
start() {
        echo -n "Starting Glassfish: "
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin --user $GLASSFISH_ADMIN --passwordfile $GLASSFISH_PASSWORD  start-local-instance --node $NODE --sync normal $INSTANCE"
        echo "done"
}
stop() {
        echo -n "Stopping Glassfish: "
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin stop-local-instance --node $NODE $INSTANCE"
        echo "done"
}
case "$1" in
        start)
                start
                ;;
        stop)
                stop
                ;;
        restart)
                stop
                start
                ;;
        *)
                echo $"Usage: Glassfish {start|stop|restart}"
                exit
esac