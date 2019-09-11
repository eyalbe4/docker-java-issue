mkdir .m2
mvn clean install -Dmaven.repo.local=.m2
rm -rf bin
# Copy all jars to the bin dir 
mkdir bin
find . -name \*.jar -exec cp {} bin \;