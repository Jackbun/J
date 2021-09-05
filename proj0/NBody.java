public class NBody{
  public static double readRadius(String filename){
     In in = new In(filename);
     in.readInt();
     double a = in.readDouble();
     return a;
  }
  public static Planet[] readPlanets(String filename){
    In in = new In(filename);
    int b = in.readInt();
    Planet[] body = new Planet[b];
    in.readDouble();
    for(int i=0; i<b; i++){
      double xp = in.readDouble();
      double yp = in.readDouble();
      double xv = in.readDouble();
      double yv = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      body[i]= new Planet(xp, yp, xv, yv, m, img);
}
    return body;
}
 public static void main(String[] args){
   double T = Double.parseDouble(args[0]);
   double dt = Double.parseDouble(args[1]);
   String filename = args[2];
   double uniradius = NBody.readRadius(filename);
   Planet[] body = NBody.readPlanets(filename);


     StdDraw.setScale(-uniradius, uniradius);
     StdDraw.clear();
     StdDraw.picture(0, 0, "images/starfield.jpg");

     for(Planet i: body){
       i.draw();
     }
     StdDraw.enableDoubleBuffering();
     int s = body.length;
     for(double r=0;r<=T;r+=dt) {
       double [] xForces = new double[s];
       double [] yForces = new double[s];

       for (int t=0; t<s; t++){
       xForces[t] = body[t].calcNetForceExertedByX(body);
       yForces[t] = body[t].calcNetForceExertedByY(body);

       }
       for (int t=0; t<s; t++){
      body[t].update(dt,xForces[t],yForces[t]);
      }
       StdDraw.setScale(-uniradius, uniradius);
       StdDraw.picture(0, 0, "images/starfield.jpg");
       for(Planet i: body){
         i.draw();
     }
     StdDraw.show();
 		 StdDraw.pause(10);


     }

     StdOut.printf("%d\n", body.length);
     StdOut.printf("%.2e\n", uniradius);
     for (int i = 0; i < body.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  body[i].xxPos, body[i].yyPos, body[i].xxVel,
                  body[i].yyVel, body[i].mass, body[i].imgFileName);
}
     }

   }
