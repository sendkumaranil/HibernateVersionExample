# HibernateVersionExample
Using XML Mapping

Optimistic Locking Version
--------------------------
Version is used to have updation count to table record value.
Versioning are used to lock automatically.

Example:
<b>Account Table</b><br>
Columns:<br>
AccoNo
Name
Balance
version

<b>Note:</b> version tag must be immediately followed by id tag.
while storing account object into database we no need to set version column,because version value given by hibernate.
the start value of version is 0.

Testing
-------
<b>Step-1:</b> Run TestVersionDemo1 <br>
<b>Step-2:</b> Run TestVersionDemo2 in debug mode and put the debug at System.out.println("Set break point here.and run TestVersionDemo3");	<br>
<b>Step-3:</b> Run TestVersionDemo3 and come at the TestVersionDemo2 debug mode and resume it.

OutPut:
------
<b>org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect):</b>
we will get above error while we updating the same record with another client (TestVersionDemo2).

RDBMS (MysQL) Table Script:
---------------------------

CREATE TABLE `account` (
  `accno` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `balance` float,
  `version` bigint(20),
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


