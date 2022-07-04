echo off
ren miss2.exe _miss2.exe
xdelta3 -d -s _miss2.exe miss2.patch miss2.exe
del _miss2.exe