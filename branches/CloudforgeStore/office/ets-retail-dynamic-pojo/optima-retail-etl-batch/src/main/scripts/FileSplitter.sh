 #!/bin/bsh
dir_name=$1
pattern_name=$2
no_of_lines=$3

str=`split -l $3 $1$2 -d $1$2_SPLIT_ --verbose | awk '{print $3}'`
head -n 1 $1$2_SPLIT_00 > $1$2_HEAD
sed -i 1d $1$2_SPLIT_00