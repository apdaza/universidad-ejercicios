divisores::Int->[Int]
divisores n=[d|d<-[1..n], n `mod` d==0]

divisoresHasta::Int->Int->[Int]
divisoresHasta n t=[d|d<-[1..t], n `mod` d==0]

divisoresCondicionales::Int->String
divisoresCondicionales n = if(mod n 5)==0 then
                             if(mod n 4)==0 then
							   if(mod n 3)==0 then
						         if(mod n 2)==0 then
								   "es divisible por 1,2,3,4,5"
						         else
						           "es divisible por 1,3,4,5"
						       else
						         if(mod n 2)==0 then
								   "es divisible por 1,2,4,5"
						         else
						           "es divisible por 1,4,5"
                             else
								if(mod n 3)==0 then
						         if(mod n 2)==0 then
								   "es divisible por 1,2,3,5"
						         else
						           "es divisible por 1,3,5"
						       else
						         if(mod n 2)==0 then
								   "es divisible por 1,2,5"
						         else
						           "es divisible por 1,5"
                           else
                             if(mod n 4)==0 then
							   if(mod n 3)==0 then
						         if(mod n 2)==0 then
								   "es divisible por 1,2,3,4"
						         else
						           "es divisible por 1,3,4"
						       else
						         if(mod n 2)==0 then
								   "es divisible por 1,2,4"
						         else
						           "es divisible por 1,4"
                             else
								if(mod n 3)==0 then
						         if(mod n 2)==0 then
								   "es divisible por 1,2,3"
						         else
						           "es divisible por 1,3"
						       else
						         if(mod n 2)==0 then
								   "es divisible por 1,2"
						         else
						           "es divisible por 1"
                           
