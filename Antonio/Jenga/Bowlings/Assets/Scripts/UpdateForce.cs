using UnityEngine;

public class UpdateForce : MonoBehaviour
{
    private Rigidbody rb;
    private int contador = 0;
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        
    }
    void Update()
    {
        rb.AddForce(Vector3.up*10.0f);   
    }
}