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

RDBMS (MysQL) Table Script:
---------------------------

CREATE TABLE `account` (
  `accno` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `balance` float,
  `version` bigint(20),
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


