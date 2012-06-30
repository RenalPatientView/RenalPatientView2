RenalPatientView
================

Renal Patient View (from http://patientview.svn.sourceforge.net/viewvc/patientview/)

You can find the database dump file at here src/sql/mysql/patientview.sql

Getting Started
---------------


* Set `tomcat.root` in `build.properties`
* Edit database details (three times) in `src/conf/dev/context.xml` and `src/conf/dev/mysql.properties`
* Update all the paths in `src/conf/dev/context.xml`
* Hack because we can't get the `Realm` config working:
    * Edit `src/conf/dev/context.xml` and replace the `Realm` directive with `<Realm className="org.apache.catalina.realm.MemoryRealm" />`
    * Edit your Tomcat's `tomcat-users.xml`, add users matching those in the database like the following:
        * `<role rolename="superadmin" />`
        * `<role rolename="patient" />`
        * `<user username="s" password="s" roles="superadmin" />`
        * `<user username="p" password="p" roles="patient" />`
