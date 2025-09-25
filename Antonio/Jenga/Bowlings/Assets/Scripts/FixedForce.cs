using UnityEngine;

public class FixedForce : MonoBehaviour
{
    private Rigidbody rb;
    private Transform tr;
    
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        tr = GetComponent<Transform>();
    }
    void FixedUpdate()
    {
        if (tr.position.y < 10)
        {
            rb.AddForce(Vector3.up*10.0f);  
        }
        else
        {
            rb.Sleep();
        }
    }
}
