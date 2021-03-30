find . -type f|while read f;  do mv $f `echo $f |tr '[:lower:]' '[:upper:]'`; done
