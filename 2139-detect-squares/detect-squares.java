class DetectSquares {
    HashMap<String,Integer>point;
    public DetectSquares() {
        point=new HashMap<>();

        
    }
    
    public void add(int[] pointk) {
        //we have points to add
        int x=pointk[0];
        int y=pointk[1];
         //add this in map 
         String key=x+","+y;
         point.put(x+","+y,point.getOrDefault(key,0)+1);

        
    }
    
    public int count(int[] pointk) {
         //count the square
         int x=pointk[0];
         int y=pointk[1];
        
         //find the digaonla point
         int c=0;
         for(String key :point.keySet())
         {   String part[]= key.split(","); //convert this to list then to convert int
            int dx=Integer.parseInt(part[0]);

             int dy=Integer.parseInt(part[1]);
             if(Math.abs(dx-x)!=Math.abs(dy-y) || dx==x ||dy==y)
             {
                continue;//not diagonal 

             }
             int p1=point.getOrDefault(dx+","+y,0);
             int p2=point.getOrDefault(x+","+dy,0);
             int p3=point.getOrDefault(key,0);
            c+= p1*p2*p3;


         }
         return c;
         
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */