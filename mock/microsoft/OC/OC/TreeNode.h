//
//  TreeNode.h
//  LC
//
//  Created by ULS on 2/12/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface TreeNode : NSObject

@property(assign)NSInteger val;
@property(nonatomic, strong) TreeNode* left;
@property(nonatomic, strong) TreeNode* right;

- (instancetype)initWith:(NSInteger)x;

@end
