ECHO OFF
SET PORT=1112
SET FILE=consensusPBFT.exe
SET PATH=D:\BlockChain\GoBlockChain\src\consensusPBFT\
SET TEMP=%PATH%test\%PORT%

ECHO ON

cd %TEMP%
%FILE% %PORT%