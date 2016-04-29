 #!/bin/ksh
 #hdr=$1
 #ftr=$2
 #dir=$1
dir=$1
filename=$2
#srchpattern=$2
#srchpattern=$2_*
# header_pattern=HEAD_$2
# footer_pattern=Footer_$2

usage ()
{
     echo "*******************************************************************************"
     echo "RRAS Application"
     echo "Script to merge all the output files into one single file along with header & footer"
     echo "Type testfilemerge.ksh with exactly 2 arguments "
     echo "usage: ./ testfilemerge.ksh <<Directory>> <<FileName>>"
#     echo "Header may be col names or if no hdr information is present then pass as ---
#     echo "Footer - if no footer is present then pass as ---
     echo " Filepattern: GN_SR67841_CRD_APAC_TW_RSK_20130930_HIST_20140317_AIP_V2.dat"
     echo "*************************************************************************"
}



# Check the no. of arguments 
#if [ $# != 2 ]
# then
#  echo " Invalid number of Arguments !!! " 
#  echo 
#   usage
#  exit 
#
#fi

#cat ${dir}$srchpattern  >> $dir$filename
current_time=$(date "+%Y%m%d%H%M%S")
cat ${dir}/processed.dat_*  >> "${dir}/output_$current_time.dat"
echo "completed"
rm ${dir}/processed.dat_*


#if [ "$hdr" !=  "---" ] 
 #then
#	cat $dir$header_pattern  >> $dir$filename	
#fi

#cat $dir$srchpattern  >> $dir$filename

#if [ "$ftr" !=  "---" ]
 #then
#	 cat $dir$footer_pattern >> $dir$filename
#fi

#rm -r $dir$footer_pattern
#rm -f $dir$srchpattern
#rm -f $dir$header_pattern
