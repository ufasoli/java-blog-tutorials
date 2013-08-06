#!/bin/bash
#
# chkconfig: 3 80 05
# description: Startup script for Glassfish
GLASSFISH_HOME=/opt/glassfish/bin;
GLASSFISH_OWNER=gfish;
GLASSFISH_DOMAIN=gfish;
CLUSTER_NAME=mycluster
export GLASSFISH_HOME GLASSFISH_OWNER GLASSFISH_DOMAIN CLUSTER_NAME
start() {
        echo -n "Starting Glassfish: "
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin start-domain $GLASSFISH_DOMAIN"
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin start-cluster $CLUSTER_NAME"
        echo "done"
}
stop() {
        echo -n "Stopping Glassfish: "
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin stop-cluster $CLUSTER_NAME"
        su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin stop-domain $GLASSFISH_DOMAIN"
        echo "done"
}
stop_cluster(){
     echo -n "Stopping glassfish cluster $CLUSTER_NAME"
     su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin stop-cluster $CLUSTER_NAME"
     echo "glassfish cluster stopped"

}

start_cluster(){
     echo -n "Starting glassfish cluster $CLUSTER_NAME"
     su $GLASSFISH_OWNER -c "$GLASSFISH_HOME/asadmin start-cluster $CLUSTER_NAME"
     echo "Glassfish cluster started"
}
case "$1" in
        start)
                start
                ;;
        stop)
                stop
                ;;
        stop-cluster)
               stop_cluster
                ;;
       start-cluster)
              start_cluster
              ;;
        restart)
                stop
                start
                ;;
        *)
                echo $"Usage: Glassfish {start|stop|restart|start-cluster|stop-cluster}"
                exit
esac