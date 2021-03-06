
package data.scripts.weapons;

import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.combat.CombatEntityAPI;
import com.fs.starfarer.api.combat.DamagingProjectileAPI;
import com.fs.starfarer.api.combat.OnHitEffectPlugin;
import com.fs.starfarer.api.combat.listeners.ApplyDamageResultAPI;

import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

public class GrapeshotHeavy implements OnHitEffectPlugin {
    
    @Override
    public void onHit(DamagingProjectileAPI projectile, CombatEntityAPI target, Vector2f point, boolean shieldHit, ApplyDamageResultAPI damageResult, CombatEngineAPI engine) {        
    	float angle = 0;
    	Vector2f spawn = point;
        if(shieldHit) {
        	angle = VectorUtils.getAngle(target.getLocation(), projectile.getLocation());
        	spawn = MathUtils.getPoint(projectile.getLocation(), 30, angle);
        }else {
        	angle = VectorUtils.getAngle(projectile.getLocation(), target.getLocation());
        }
        for(int i = 0;i < 12 ;i++) {
    		float newangle = angle -45 + (float)(Math.random()*90f);
    		engine.spawnProjectile(projectile.getSource(), projectile.getWeapon(), "edshipyard_SC0", spawn, newangle, new Vector2f());
    	}
    }
}
