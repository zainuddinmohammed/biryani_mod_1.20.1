package net.zain.biryani.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class ScreamingNetherBricks extends Block {

    public ScreamingNetherBricks(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {

        pLevel.playSound(pPlayer, pPos, SoundEvents.BLAZE_AMBIENT, SoundSource.BLOCKS, 1f, 1f);

        this.spawnDestroyParticles(pLevel, pPlayer, pPos, pState);

        pLevel.gameEvent(GameEvent.BLOCK_DESTROY, pPos, GameEvent.Context.of(pPlayer, pState));

    }
}
