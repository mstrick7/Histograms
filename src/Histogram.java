import edu.princeton.cs.introcs.StdDraw;

public class Histogram {
        public static void main(String[] args) {
                //take inputs and assign variables

                int n = Integer.parseInt(args[0]);
                double lo = Double.parseDouble(args[1]);
                double hi = Double.parseDouble(args[2]);

                //need 1000 random doubles between lo and hi

                double[] randomDubs = new double [1000];
                for (int i = 0 ; i < 1000 ; i++) {
                        randomDubs[i] = (Math.random() * hi - lo) + lo;
                }

                //need length of intervals
                double intervalLength = (hi - lo) / n;

                //need a count of the doubles at each interval, there are n intervals

                int[] bar = new int[n];
                int intervalNumber = -1;
                for (double j = lo ; j <= hi ; j = j + intervalLength){
                        //System.out.println(j);
                        intervalNumber = intervalNumber+1;
                        //System.out.println(intervalNumber);
                        int sumbar = 0;
                        for (int k = 0 ; k < 1000 ; k++){
                                if (randomDubs[k] > j && randomDubs[k] < j + intervalLength){

                                        sumbar=sumbar+1;
                                }
                                if (j + intervalLength > hi)break;
                                bar[intervalNumber] = sumbar;
                        }

                }
                //the code above sorts the random double counts into an array
                //based on interval number and length.
                //now need to output the data in histogram form
                double xloc=lo;
                StdDraw.setXscale(lo, hi);
                StdDraw.setYscale(0, 600);
                for (int l = 0; l < bar.length; l++){
                        StdDraw.filledRectangle(xloc+(intervalLength/2), 0, intervalLength/3,bar[l]);
                        xloc = xloc +intervalLength;
                }


        }
}
