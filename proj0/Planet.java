import java.lang.Math;
public class Planet{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  public static final double G = 6.67e-11;
  public Planet(double xP, double yP, double xV, double yV, double m, String img){
     xxPos = xP;
     yyPos = yP;
     xxVel = xV;
     yyVel = yV;
     mass = m;
     imgFileName = img;
  }

  public Planet(Planet p) {
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
  }
  public double calcDistance(Planet p){
    double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double r = Math.hypot(dx, dy);
        return r;
  }

 public double calcForceExertedBy(Planet p){
    double F = (G*this.mass*p.mass)/(this.calcDistance(p)*this.calcDistance(p));
    return F;

 }
 public double calcForceExertedByX(Planet p){
   double x = p.xxPos - this.xxPos;
   double Fx = (this.calcForceExertedBy(p)*x)/this.calcDistance(p);
   return Fx;
 }
 public double calcForceExertedByY(Planet p){
   double y = p.yyPos - this.yyPos;
   double Fy = (this.calcForceExertedBy(p)*y)/this.calcDistance(p);
   return Fy;
 }

 public double calcNetForceExertedByX(Planet[] planets){
   double Fxnet = 0;
   for (Planet p: planets){
     if (this.equals(p)){
       continue;
     }
     Fxnet += this.calcForceExertedByX(p);
   }
   return Fxnet;
 }
   public double calcNetForceExertedByY(Planet[] planets){
     double Fynet = 0;
    for (Planet p: planets){
      if (this.equals(p)){
        continue;
      }
      Fynet += this.calcForceExertedByY(p);
}
    return Fynet;
}


public void update(double dt, double fX, double fY){
  double ax = fX/this.mass;
  double ay = fY/this.mass;
  this.xxVel += dt*ax;
  this.yyVel += dt*ay;
  this.xxPos += dt*this.xxVel;
  this.yyPos += dt*this.yyVel;
  }
  public void draw(){

    StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
  }
}
