 #!/bin/ksh
 hdr=$1
 ftr=$2
 dir=$3
 filename=$4
 srchpattern=$4_*

usage ()
{
     echo "*******************************************************************************"
     echo "RRAS Application"
     echo "Script to merge all the output files into one single file along with header & footer"
     echo "Type testfilemerge.ksh with exactly 3 arguments "
     echo "usage: ./ testfilemerge.ksh <<Header>> <<Footer>> <<Directory>> <<FileName>>"
     echo "Header may be col names or if no hdr information is present then pass as ---
     echo "Footer - if no footer is present then pass as ---
     echo " Filepattern: GN_SR67841_CRD_APAC_TW_RSK_20130930_HIST_20140317_AIP_V2.dat"
     echo "*************************************************************************"
}



# Check the no. of arguments 
if [ $# != 4 ]
 then
  echo " Invalid number of Arguments !!! " 
  echo 
   usage
  exit 

fi

if [ "$hdr" !=  "---" ] 
 then
	echo $hdr  >> $dir$filename	
fi

cat $dir$srchpattern  >> $dir$filename

if [ "$ftr" !=  "---" ]
 then
	echo "$ftr"  >> $dir$filename
fi
