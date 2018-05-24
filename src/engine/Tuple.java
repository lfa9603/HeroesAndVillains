package engine;


/*
 * 
 *'Python style' tuples that accept three parameters.
 *
 */
public class Tuple<K, V, T> implements java.io.Serializable {

	private static final long serialVersionUID = -5110956299483141961L;
	private K k;
	private V v;
	private T t;
	
	public Tuple(K k, V v, T t) {
		this.k = k;
		this.v = v;
		this.t= t;
	}
	
	/**
	 * @param k the k to set
	 */
	public void setK(K k) {
		this.k = k;
	}


	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}


	/**
	 * @param t the t to set
	 */
	public void setT(T t) {
		this.t = t;
	}


	/**
	 * @param v the v to set
	 */
	public void setV(V v) {
		this.v = v;
	}




	/**
	 * @return the k
	 */
	public K getK() {
		return k;
	}


	/**
	 * @return the v
	 */
	public V getV() {
		return v;
	}
	
}
