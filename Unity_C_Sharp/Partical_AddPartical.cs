//ADD PARTICAL
ParticleSystem particleSystem = obj.AddComponent<ParticleSystem>();
Renderer render = particleSystem.GetComponent<Renderer>();
render.material = matDuman;

//Partical Renderer Olması Lazım
