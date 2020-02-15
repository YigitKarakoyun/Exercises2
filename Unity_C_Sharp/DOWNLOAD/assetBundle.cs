AssetBundles let you stream additional assets via the UnityWebRequest class and instantiate them at runtime. AssetBundles are created via BuildPipeline.BuildAssetBundle.

Note that bundles are not compatible between platforms. A bundle built for any of the standalone platforms can only be loaded on that platform but not others. Further example, a bundle built for iOS is not compatible with Android and vice versa. One difference is shaders which are different between devices, as are textures.

See Also: UnityWebRequestAssetBundle.GetAssetBundle, Loading Resources at Runtime, BuildPipeline.BuildAssetBundle.

using System.Collections;
using UnityEngine;
using UnityEngine.Networking;

public class SampleBehaviour : MonoBehaviour
{
    IEnumerator Start()
    {
        var uwr = UnityWebRequestAssetBundle.GetAssetBundle("http://myserver/myBundle.unity3d");
        yield return uwr.SendWebRequest();

        // Get an asset from the bundle and instantiate it.
        AssetBundle bundle = DownloadHandlerAssetBundle.GetContent(uwr);
        var loadAsset = bundle.LoadAssetAsync<GameObject>("Assets/Players/MainPlayer.prefab");
        yield return loadAsset;

        Instantiate(loadAsset.asset);
    }
}
