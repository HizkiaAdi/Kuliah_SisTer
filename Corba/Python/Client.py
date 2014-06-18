#!/usr/bin/env python

import sys															
from omniORB import CORBA											
import _GlobalIdl

orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

ior = "corbaloc::192.168.137.63:1050/PingService"
obj = orb.string_to_object(ior)

eo = obj._narrow(_GlobalIdl.Service)

mesg = "Hello from Python"
result = eo.hello(mesg) 

print "Hasil dari Server %s." % result