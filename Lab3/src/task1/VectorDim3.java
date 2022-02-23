package task1;

public class VectorDim3 {

    private float x_start;
    private float x_end;
    private float y_start;
    private float y_end;
    private float z_start;
    private float z_end;

    public VectorDim3() {
    }

    public VectorDim3(float x_start, float x_end, float y_start, float y_end, float z_start, float z_end) {
        this.x_start = x_start;
        this.x_end = x_end;
        this.y_start = y_start;
        this.y_end = y_end;
        this.z_start = z_start;
        this.z_end = z_end;
    }

    public float scalarProduct(VectorDim3 other){
        return (this.x_end - this.x_start) * (other.x_end - other.x_start) + (this.y_end - this.y_start) * (other.y_end - other.y_start) + (this.z_end - this.z_start) * (other.z_end - other.z_start);
    }

    public boolean isOrthogonal(VectorDim3 other){
        if(scalarProduct(other) == 0.){
            return true;
        } else {
            return false;
        }
    }

    public boolean isCrossed(VectorDim3 other, float eps){
        /*
        x = x_start*t + x_end*(1 - t)
        y = y_start*t + y_end*(1 - t)
        z = z_start*t + z_end*(1 - t)

        this.x_start*t + this.x_end*(1 - t) = other.x_start*s + other.x_end*(1 - s)
        this.y_start*t + this.y_end*(1 - t) = other.y_start*s + other.y_end*(1 - s)
         */
        double s = ((other.y_end - this.y_end)/(this.y_start - this.y_end) - (other.x_end - this.x_end)/(this.x_start - this.x_end))/((other.x_start - other.x_end)/(this.x_start - this.x_end) - (other.y_start - other.y_end)/(this.y_start - this.y_end));
        double t = s*((other.x_start - other.x_end)/(this.x_start - this.x_end)) + (other.x_end - this.x_end)/(this.x_start - this.x_end);

        double left = this.z_start * t + this.z_end * (1 - t);
        double right = other.z_start * s + other.z_end * (1 - s);

        if((left - right) <= eps){
            return true;
        } else {
            return false;
        }
    }

    public String compareVectors(VectorDim3 other){
        double firstModulus = Math.sqrt(Math.pow((this.x_end - this.x_start), 2) + Math.pow((this.y_end - this.y_start), 2) + Math.pow((this.z_end - this.z_start), 2));
        double secondModulus = Math.sqrt(Math.pow((other.x_end - other.x_start), 2) + Math.pow((other.y_end - other.y_start), 2) + Math.pow((other.z_end - other.z_start), 2));
        if(firstModulus > secondModulus){
            return "First vector is greater";
        } else if(firstModulus < secondModulus){
            return "Second vector is greater";
        } else {
            return "Vector have same length";
        }
    }

    public boolean areComplanar(VectorDim3 other, VectorDim3 another) {
        float this_x = this.x_end - this.x_start;
        float this_y = this.y_end - this.y_start;
        float this_z = this.z_end - this.z_start;

        float other_x = other.x_end - other.x_start;
        float other_y = other.y_end - other.y_start;
        float other_z = other.z_end - other.z_start;

        float tmpX = this_y * other_z - this_z * other_y;
        float tmpY = -(this_x * other_z - this_z * other_x);
        float tmpZ = this_z * other_y - this_y * other_x;

        float another_x = another.x_end - another.x_start;
        float another_y = another.y_end - another.y_start;
        float another_z = another.z_end - another.z_start;

        float sumOfMuls = tmpX * another_x + tmpY * another_y + tmpZ * another_z;

        if(sumOfMuls == 0.){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "VectorDim3{" +
                "x_start=" + x_start +
                ", x_end=" + x_end +
                ", y_start=" + y_start +
                ", y_end=" + y_end +
                ", z_start=" + z_start +
                ", z_end=" + z_end +
                '}';
    }
}
